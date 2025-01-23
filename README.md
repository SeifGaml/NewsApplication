# News Application (kotlin)

This is a sample news application built for Android using the Kotlin programming language. The app fetches the latest news from various categories such as Technology, Sports, Health, and more.

## Features:
- Display news articles from various categories.
- Supports pagination and search functionality.
- Clean and modern UI built using the MVVM architectural pattern.

## API:
The application uses a news API to fetch real-time data, which is displayed in the app. It supports multiple news sources and provides updates dynamically.

## Dependencies:

| **Name**           | **Description**                                                                                                                                                 |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **LiveData**        | LiveData is an observable data holder class that allows us to monitor changes in data. LiveData is lifecycle-aware and helps ensure that data updates are only made when the UI is in a valid state. |
| **Retrofit**        | Retrofit is a type-safe HTTP client for Android and Java that simplifies making API calls and parsing responses.                                                  |
|       |
| **Coroutines**      | Coroutines simplify asynchronous programming by allowing operations to run in the background without blocking the main thread. It’s used to handle tasks like network calls and database operations. |
| **Room**            | Room provides an abstraction layer over SQLite, allowing you to interact with a local database seamlessly. It simplifies database operations while ensuring full access to SQLite. |
| **View Binding**    | View Binding allows you to interact with views in a more efficient and type-safe manner. It eliminates the need for `findViewById()` calls and helps avoid null pointer exceptions. |
| **MVVM**            | MVVM (Model-View-ViewModel) is the architectural pattern used in this app: <br> - **Model**: Contains the data of the application. <br> - **View**: Represents the UI elements of the application. <br> - **ViewModel**: Mediates between the Model and the View. |
| **Data Binding**    | Data Binding allows you to bind UI components in layouts to data sources declaratively, rather than writing code to update views manually.                         |
| **Jetpack**         | Jetpack is a suite of libraries, tools, and architectural guidance that simplifies app development. It includes libraries like Room, Hilt, Paging, and Data Binding. |
| **Glide**           | Glide is an image loading and caching framework for Android that allows you to load images from the web or local storage with minimal setup.                      |


