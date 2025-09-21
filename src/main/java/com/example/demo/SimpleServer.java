package com.example.demo;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.SecureRandom;

public class SimpleServer {
    static String htmlCssString = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Amazing Featured Website</title>
                <style>
                    * {
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                        font-family: 'Arial', sans-serif;
                    }

                    body {
                        background-color: #f0f2f5;
                        color: #333;
                    }

                    /* Navigation Bar */
                    .navbar {
                        background: linear-gradient(90deg, #6a11cb, #2575fc);
                        padding: 15px 0;
                        position: fixed;
                        width: 100%;
                        top: 0;
                        z-index: 1000;
                        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
                    }

                    .navbar .container {
                        max-width: 1200px;
                        margin: 0 auto;
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                    }

                    .navbar .logo {
                        color: white;
                        font-size: 24px;
                        font-weight: bold;
                        text-decoration: none;
                    }

                    .navbar .nav-links a {
                        color: white;
                        text-decoration: none;
                        margin: 0 15px;
                        font-size: 16px;
                        transition: color 0.3s ease;
                    }

                    .navbar .nav-links a:hover {
                        color: #ffd700;
                    }

                    /* Hero Section */
                    .hero {
                        height: 100vh;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        text-align: center;
                        background: linear-gradient(135deg, #667eea, #764ba2);
                        color: white;
                        padding: 20px;
                    }

                    .hero-content h1 {
                        font-size: 48px;
                        margin-bottom: 20px;
                        animation: fadeInDown 1s ease-in-out;
                    }

                    .hero-content p {
                        font-size: 20px;
                        margin-bottom: 30px;
                        max-width: 600px;
                    }

                    .hero-content .btn {
                        background-color: #ffd700;
                        color: #333;
                        padding: 12px 24px;
                        text-decoration: none;
                        border-radius: 5px;
                        font-weight: bold;
                        transition: background-color 0.3s ease, transform 0.3s ease;
                    }

                    .hero-content .btn:hover {
                        background-color: #e6c200;
                        transform: translateY(-3px);
                    }

                    /* Features Section */
                    .features {
                        max-width: 1200px;
                        margin: 50px auto;
                        padding: 20px;
                    }

                    .features h2 {
                        text-align: center;
                        font-size: 36px;
                        margin-bottom: 40px;
                    }

                    .feature-grid {
                        display: grid;
                        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                        gap: 20px;
                    }

                    .feature-card {
                        background: white;
                        padding: 20px;
                        border-radius: 10px;
                        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                        text-align: center;
                        transition: transform 0.3s ease, box-shadow 0.3s ease;
                    }

                    .feature-card:hover {
                        transform: translateY(-5px);
                        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
                    }

                    .feature-card i {
                        font-size: 40px;
                        color: #6a11cb;
                        margin-bottom: 15px;
                    }

                    .feature-card h3 {
                        font-size: 24px;
                        margin-bottom: 10px;
                    }

                    .feature-card p {
                        color: #666;
                    }

                    /* Footer */
                    .footer {
                        background: #333;
                        color: white;
                        text-align: center;
                        padding: 20px;
                        margin-top: 50px;
                    }

                    .footer p {
                        font-size: 14px;
                    }

                    /* Animations */
                    @keyframes fadeInDown {
                        from {
                            opacity: 0;
                            transform: translateY(-20px);
                        }
                        to {
                            opacity: 1;
                            transform: translateY(0);
                        }
                    }

                    /* Responsive Design */
                    @media (max-width: 768px) {
                        .hero-content h1 {
                            font-size: 32px;
                        }

                        .hero-content p {
                            font-size: 16px;
                        }

                        .navbar .nav-links a {
                            font-size: 14px;
                            margin: 0 10px;
                        }
                    }
                </style>
            </head>
            <body>
                <nav class="navbar">
                    <div class="container">
                        <a href="#" class="logo">MyWebsite</a>
                        <div class="nav-links">
                            <a href="#home">Home</a>
                            <a href="#features">Features</a>
                            <a href="#about">About</a>
                            <a href="#contact">Contact</a>
                        </div>
                    </div>
                </nav>

                <section class="hero" id="home">
                    <div class="hero-content">
                        <h1>Welcome to Our Amazing Website</h1>
                        <p>Discover a world of possibilities with our cutting-edge features and modern design.</p>
                        <a href="#features" class="btn">Explore Now</a>
                    </div>
                </section>

                <section class="features" id="features">
                    <h2>Our Features</h2>
                    <div class="feature-grid">
                        <div class="feature-card">
                            <i class="fas fa-rocket"></i>
                            <h3>Fast Performance</h3>
                            <p>Experience lightning-fast load times and smooth interactions.</p>
                        </div>
                        <div class="feature-card">
                            <i class="fas fa-shield-alt"></i>
                            <h3>Secure Platform</h3>
                            <p>Your data is protected with state-of-the-art security measures.</p>
                        </div>
                        <div class="feature-card">
                            <i class="fas fa-mobile-alt"></i>
                            <h3>Responsive Design</h3>
                            <p>Seamless experience across all devices, from desktop to mobile.</p>
                        </div>
                    </div>
                </section>

                <!-- Footer -->
                <footer class="footer">
                    <p>&copy; 2025 MyWebsite. All rights reserved.</p>
                </footer>
            </body>
            </html>
            """;

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
            server.createContext("/", new RandomNumberHandler());
            server.start();
            System.out.println("Server started on port 80");
        } catch (Exception e) {
            System.out.println("Server failed to start " + e.getMessage());
        }
    }

    static class RandomNumberHandler implements HttpHandler {
        private final SecureRandom random = new SecureRandom();

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.sendResponseHeaders(200, htmlCssString.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(htmlCssString.getBytes());
            }
        }
    }
}