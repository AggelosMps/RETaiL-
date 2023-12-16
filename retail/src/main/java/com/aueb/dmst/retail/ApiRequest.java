package com.aueb.dmst.retail;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.io.IOException;

public class ApiRequest {
    
    public static String getApothema(String user) {
        String systemMessage = "You are a manager in a supermarket. I will give you a product name, quantity of the product now, quantity of the product yesterday, and quantity of the product the day before yesterday. How much product should I buy. Calculate the product using the supply and demand product and display it in the exact form using 2 tokens. Name of the product, quantity I should buy.";
        String userMessage = user;
        String response =  extractContent(chatGptConnection(systemMessage, userMessage));
        return response;
    }

    public static String getPrice(String user) {
        String systemMessage = "You are a manager in a supermarket. I will give you a product name, selling price, purchase cost, quantity of the product now, quantity of the product yesterday, and quantity of the product the day before yesterday. Give me a new selling price. Calculate the price using the supply and demand, the  category of the product, the difference between the selling price and the purchase costand display it in the exact form using 2 tokens. Name of the product, new price.";
        String userMessage = user;
        String response =  extractContent(chatGptConnection(systemMessage, userMessage));
        return response;
    }

    public static String getSchedule(String user) {
        //String systemMessage = "The application involves creating a schedule for a supermarket. I will provide you with the operating days and hours of the store in the format <Day>, <store opening time>, <store closing time>, and Staff with the hours they can work in the format <employee name>, <Day they can work>, <hours they can work for that day>. Each store must have exactly 2 employees at the same time, each employee can work up to 8 hours a day. I want the results in the following format: <Day>, <employee name>, <start time of their schedule>, <end time of their schedule>, without any other comment";
        String systemMessage = "The application involves creating a schedule for a supermarket. I will provide you with the operating days and hours of the store in the format Day, store opening time, store closing time, and Staff with the hours they can work in the format employee name, Day they can work, hours they can work for that day. Each store must have 2 employees at the same time, each employee can work up to 8 hours a day. Display it in the exact form using 2 tokens. <Day>, <employee name>, <start time of their schedule>, <end time of their schedule>";
        String userMessage = user;
        String response =  extractContent(chatGptConnection(systemMessage, userMessage));
        return response;
    }

    public static String getCategorization(String user) {
        String systemMessage = "You are a supermarket application that will help in extracting financial information. You will receive in the format: product name, sales_profit and you will return in the same format only the product category, total sales profit of category";
        String userMessage = user;
        String response =  extractContent(chatGptConnection(systemMessage, userMessage));
        return response;
    }


    //Κόβει το String της απάντησης του Chat Gpt, (χρειάζαι και dependency στο maven)
        public static String extractContent(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        String content = jsonObject.getJSONArray("choices")
                                   .getJSONObject(0)
                                   .getJSONObject("message")
                                   .getString("content");
        return content;
    }

    //To request στο chatgpt 
    public static String chatGptConnection(String systemMessage, String userMessage) {
        String apiKey = readEnvironmentVariable("API_KEY");
        // Replace the URL with the correct OpenAI API endpoint
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        // Replace with your model name
        String modelName = "gpt-4";
        // Construct the JSON payload
        String jsonPayload = String.format("{\"model\": \"%s\", \"messages\": [{\"role\": \"system\", \"content\": \"%s\"}, {\"role\": \"user\", \"content\": \"%s\"}]}", modelName, systemMessage, userMessage);

        // Set up the HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();
        
        try {
            // Send the HTTP request and retrieve the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Return response body
            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getStrings(String in) {
        String input = in;

        // Διαχωρισμός του string σε δύο μέρη βάσει της κόμμας
        String[] parts = input.split(", ");

        // Εξαγωγή του κειμένου αριστερά της κόμμας
        String text = parts[0];

        return text;
    }

    public static Integer getInt(String in) {
        String input = in;

        // Διαχωρισμός του string σε δύο μέρη βάσει της κόμμας
        String[] parts = input.split(",");
        
        // Εξαγωγή του ακέραιου δεξιά της κόμμας και μετατροπή του σε int
        int number = Integer.parseInt(parts[1]);

        return number;
    }

    public static String readEnvironmentVariable(String API_KEY) {
        return System.getenv(API_KEY);
    }
}
