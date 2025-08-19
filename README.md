# WorkoutStand - Fitness & Exercise Application

A comprehensive fitness and exercise management application featuring user authentication, workout plan generation, weight tracking, and more.

## Project Structure

```
WorkoutStand/
├── WorkoutStand-frontend/     # Vue.js Frontend Application
├── WorkoutStand-backend/      # Spring Boot Backend API
└── README.md                  # Project Documentation
```

## Tech Stack

### Frontend (WorkoutStand-frontend)
- **Framework**: Vue.js 2.6.11
- **Build Tool**: Vue CLI 4.5.0
- **Development Server**: Port 8080
- **Main Features**: User Interface, Form Handling, API Integration

### Backend (WorkoutStand-backend)
- **Framework**: Spring Boot 2.5.6
- **Language**: Java 11
- **Build Tool**: Maven
- **Database**: MySQL 8.0.27
- **API Server**: Port 8082

## Features

### User Management
- ✅ User Registration/Login
- ✅ Password Management
- ✅ Account Deletion
- ✅ User Logout

### Fitness Features
- ✅ Exercise Search
- ✅ Personalized Workout Plan Generation
- ✅ Weight Tracking and Monitoring
- ✅ User Fitness Goal Setting

### Data Management
- ✅ User Profile Management (Age, Gender, Weight, Height)
- ✅ Fitness Level Assessment
- ✅ Gym Access Configuration
- ✅ Available Time Settings

## Quick Start

### Prerequisites
- Node.js 12+ (Frontend)
- Java 11+ (Backend)
- Maven 3.6+ (Backend)
- MySQL 8.0+ (Database)

### Installation and Setup

#### 1. Clone the Repository
```bash
git clone <repository-url>
cd WorkoutStand
```

#### 2. Run Frontend
```bash
cd WorkoutStand-frontend
npm install
npm run serve
```
Frontend will be available at http://localhost:8080

#### 3. Run Backend
```bash
cd WorkoutStand-backend
./mvnw spring-boot:run
```
Backend API will be available at http://localhost:8082

### Database Configuration

The project uses a remote MySQL database with the following configuration:
- **Host**: 35.223.44.116:3306
- **Database**: WorkOutStand
- **Username**: root
- **Password**: 11111111

## API Endpoints

### Authentication
- `POST /login_post` - User Login
- `POST /sign_up_post` - User Registration
- `POST /sign_out_post` - User Logout

### Account Management
- `POST /change_password_post` - Change Password
- `POST /delete_account_post` - Delete Account

### Fitness Features
- `POST /search_post` - Search Exercises
- `POST /ge_plan_post` - Generate Workout Plan
- `POST /new_weight_post` - Update Weight Record
- `POST /max_age_post` - Query Highest Age User
- `POST /magic_post` - Special Query Function

## Database Schema

### Main Tables
- `User` - User Basic Information
- `Demands` - User Fitness Requirements
- `exercise` - Exercise Library
- `exercise_plan` - Workout Plan Templates
- `PrintCongret` - System Configuration

## Development

### Frontend Development
```bash
cd WorkoutStand-frontend
npm run serve    # Development Server
npm run build    # Production Build
npm run lint     # Code Linting
```

### Backend Development
```bash
cd WorkoutStand-backend
./mvnw spring-boot:run    # Run Application
./mvnw test              # Run Tests
./mvnw clean package     # Build JAR
```

## Project Highlights

1. **Responsive Design**: Adapts to different device screens
2. **Personalized Recommendations**: Generates customized workout plans based on user information
3. **Data Visualization**: Weight change tracking
4. **User-Friendly**: Clean and intuitive user interface
5. **Cross-Origin Support**: Frontend-backend separation architecture

## Security Notice

⚠️ **Important**: The current version contains hardcoded database credentials. For production environments, please use environment variables or configuration files to manage sensitive information.

## Contributing

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Contact

For questions or suggestions, please contact us through:
- Project Issues: [GitHub Issues](https://github.com/your-username/WorkoutStand/issues)
- Email: your-email@example.com

---

**WorkoutStand** - Making fitness easier, making life healthier! 💪
