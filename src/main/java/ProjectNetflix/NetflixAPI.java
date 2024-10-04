package ProjectNetflix;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NetflixAPI {
    private static final String BASE_URL = "http://www.omdbapi.com/?apikey=2aa53acd&t="; // Change this to your endpoint
    private static final int CACHE_SIZE = 10;
    private static final Map<String, String> cache = new HashMap<>(); // Use a simple HashMap as cache
    private static int cacheHits = 0;
    private static int cacheMisses = 0;
    private static final String LOCAL_FILE_PATH = "movies_data.txt"; // Local file to store movie data

    public static void main(String[] args) {
        List<String> movies = Arrays.asList(
                "Guardians of the Galaxy Vol. 2", "Interstellar", "The Dark Knight", "Inception",
                "The Matrix", "Avatar", "The Godfather", "Pulp Fiction", "Fight Club",
                "Forrest Gump", "The Shawshank Redemption", "The Lord of the Rings: The Return of the King"
        );

        // Fetch movies first time
        fetchMovies(movies);
        displayCacheStats(); // Display hits and misses after the first fetch

        // Fetch movies again to test cache
        System.out.println("\nFetching movies again to check cache...");
        fetchMovies(movies);
        displayCacheStats(); // Display hits and misses after the second fetch
    }

    public static void fetchMovies(List<String> movieTitles) {
        cacheHits = 0;    // Reset cache hits before fetching
        cacheMisses = 0;  // Reset cache misses before fetching

        ExecutorService executorService = Executors.newFixedThreadPool(1); // Create a thread pool

        List<Future<String>> futures = new ArrayList<>();
        for (String title : movieTitles) {
            futures.add(executorService.submit(() -> fetchMovieData(title)));
        }

        // Wait for all tasks to complete
        for (Future<String> future : futures) {
            try {
                future.get(); // Get result but do not print it
            } catch (Exception e) {
                System.err.println("Error fetching movie data: " + e.getMessage());
            }
        }
        executorService.shutdown(); // Shutdown the executor service
    }


    private static String fetchMovieData(String title) {
        long startTime = System.nanoTime(); // Start measuring time

        // Check if the movie data is in the cache
        if (cache.containsKey(title)) {
            cacheHits++;
            long endTime = System.nanoTime();
            System.out.println("Cache Hit: " + title + " (Time taken: " + (endTime - startTime) + " ns)");
            return cache.get(title); // Return cached data
        } else {
            cacheMisses++;
            System.out.println("Cache Miss: " + title);
        }

        // Check local file if not found in cache
        String localData = readMovieFromFile(title);
        if (localData != null) {
            long endTime = System.nanoTime();
            cache.put(title, localData); // Cache the response from the local file
            System.out.println("Fetched from local file: " + title + " (Time taken: " + (endTime - startTime) + " ns)");
            return localData; // Return data from local file
        }

        // Fetch data from API if not found in cache or file
        try {
            String jsonResponse = fetchMovieFromAPI(title);
            if (jsonResponse != null) {
                cache.put(title, jsonResponse); // Cache the response
                writeMovieToFile(title, jsonResponse); // Store the response in the local file
                long endTime = System.nanoTime();
                System.out.println("Fetched from API: " + title + " (Time taken: " + (endTime - startTime) + " ns)");
            }
            return jsonResponse;
        } catch (Exception e) {
            System.err.println("Error fetching movie data for " + title + ": " + e.getMessage());
            return null;
        }
    }

    private static String fetchMovieFromAPI(String title) throws Exception {
        String urlString = BASE_URL + title.replace(" ", "%20"); // Replace spaces with %20 for URL encoding
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set timeouts
        conn.setConnectTimeout(5000); // 5 seconds
        conn.setReadTimeout(5000); // 5 seconds

        // Check the response code
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        // Parse JSON and extract relevant fields
        return parseMovieData(response.toString());
    }

    private static String parseMovieData(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Extract required fields
        String title = jsonObject.get("Title").getAsString();
        String year = jsonObject.get("Year").getAsString();
        String rated = jsonObject.get("Rated").getAsString();
        String released = jsonObject.get("Released").getAsString();

        return String.format("Title: %s, Year: %s, Rated: %s, Released: %s", title, year, rated, released);
    }

    private static void writeMovieToFile(String title, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOCAL_FILE_PATH, true))) {
            writer.write(title + " | " + data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing movie data to file: " + e.getMessage());
        }
    }

    private static String readMovieFromFile(String title) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(LOCAL_FILE_PATH));
            for (String line : lines) {
                if (line.startsWith(title + " | ")) {
                    return line.substring(line.indexOf("|") + 2); // Return data after the title
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading movie data from file: " + e.getMessage());
        }
        return null; // Return null if the movie is not found in the file
    }

    private static void displayCacheStats() {
        System.out.println("Cache Hits: " + cacheHits);
        System.out.println("Cache Misses: " + cacheMisses);
    }
}
