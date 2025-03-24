## 📱 Real-Time Spring Boot Chat Application

🚀 Overview

This is a powerful Real-Time Chat Application built with Spring Boot and WebSockets. It enables seamless communication between multiple users using STOMP (Simple Text Oriented Messaging Protocol) and SockJS for enhanced compatibility with various browsers. The app is designed to deliver fast, responsive, and interactive messaging.

## 🧩 Key Technologies Used

- Java 21 with Spring Boot

- WebSocket & STOMP for real-time communication

- SockJS for fallback compatibility

- HTML5, CSS3, and Bootstrap for UI design

# 📂 Project Structure

![image](https://github.com/user-attachments/assets/911aac36-037d-4976-85db-c807e15e3f50)

## ⚙️ Setup Instructions

Follow these steps to run the application on your local machine:

1 - Clone the Repository:
```
   git clone https://github.com/dwivedikirtiman/Real-Time-ChatApplication.git
```
2 - Navigate to Project Directory:
```
   cd app
```

3- Configure Dependencies

Ensure your pom.xml has these necessary following dependencies:

 ```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>
    <dependency>
      <groupId>org.webjars</groupId>
      <artifactId>sockjs-client</artifactId>
      <version>1.5.1</version>
    </dependency>
    <dependency>
      <groupId>org.webjars</groupId>
      <artifactId>stomp-websocket</artifactId>
      <version>2.3.3</version>
    </dependency>
```

4 - Build the Project:
```
./mvnw clean install
```

5 - Run the Application:
```
./mvnw spring-boot:run
```

6 - Access the Application:

Open ```http://localhost:8080/chat``` in your browser.

## 🔥 Features

✅ Real-time messaging using WebSocket and STOMP.

✅ Lightweight UI with Bootstrap for responsive design.

✅ Automatic message updates with smooth auto-scrolling.

✅ Error handling with meaningful alerts for user guidance.

✅ Fallback support for browsers that do not support WebSocket using SockJS.

## 🔍 Technical Breakdown

- ```WebSocketConfig.java``` — Configures WebSocket endpoints and message broker settings.

- ```WebSocketController.java``` — Manages incoming and outgoing messages via WebSocket channels.

- ```ChatMessage.java``` — Data model for handling chat messages.

- ```chat.html``` — The front-end interface for real-time chat functionality.

- SockJS & STOMP — Ensures compatibility with older browsers and reliable messaging protocols.


## 🧑‍💻 Code Highlights/Code Snippets

- WebSocketConfig.java (Core WebSocket Configuration)

```
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}

```

- WebSocketController.java (Handles Real-time Messaging)

```
@Controller
public class WebSocketController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Received from Client: " + message.getSender() + ": " + message.getContent());
        return message;
    }
}

```

- chat.html (User Interface)

```
<div class="input-group mb-3">
    <input id="messageInput" type="text" class="form-control" placeholder="Type your message..." />
    <div id="input-group-append">
        <button id="sendMessage" class="btn btn-primary">Send</button>
    </div>
</div>

```

## Screenshots/Output 

- Some of the screenshots of the projects is as follows-

User1
![image](https://github.com/user-attachments/assets/2ec99d61-2250-4b52-867b-2b9195fe1d77)

User2
![image](https://github.com/user-attachments/assets/6360ccc7-0f88-4bfd-b78c-e93becb50283)

User3
![image](https://github.com/user-attachments/assets/fd935a86-455b-4328-93bb-8ab19b4e747c)

Real-Time Concurrent Screens of all the involved users in the communication
![image](https://github.com/user-attachments/assets/eb8a0120-6f52-4050-b7a9-d990095c6de1)


## 📈 Future Improvements (Optional/Suggestions)

🔹 Add user authentication for enhanced security.

🔹 Implement chat room functionality for group conversations.

🔹 Improve UI with animations and enhanced styling.


## 🤝 Contribution

- Contributions are welcome! If you'd like to improve this project, please follow these steps:

- Fork the repository.

- Create a new branch: ```git checkout -b feature/your-feature-name```

- Commit your changes: ```git commit -m 'Add new feature'```

- Push to your branch: ```git push origin feature/your-feature-name```

- Submit a pull request.

## 📜 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**[Kirtiman Dwivedi]**

GitHub: https://github.com/dwivedikirtiman

Email: [dwivedikirtiman000@gmail.com]

Let’s connect—I’d love to hear your feedback! 🚀
