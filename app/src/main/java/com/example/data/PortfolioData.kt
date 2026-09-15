package com.example.data

data class ProjectItem(
    val id: String,
    val number: String,
    val title: String,
    val techStack: String,
    val category: String,
    val visualSymbol: String,
    val bullets: List<String>,
    val tags: List<String>,
    val keyFeatures: List<String>
)

data class SkillItem(
    val name: String,
    val description: String,
    val category: String,
    val iconName: String
)

data class EducationItem(
    val degree: String,
    val institution: String,
    val period: String,
    val statusOrScore: String,
    val isOngoing: Boolean = false
)

data class CertificationItem(
    val title: String,
    val issuerOrProgram: String,
    val note: String? = null
)

data class AchievementItem(
    val title: String,
    val context: String,
    val highlight: String
)

data class SkillGroup(
    val title: String,
    val iconSymbol: String,
    val tags: List<String>,
    val isHighlighted: Boolean = false
)

object PortfolioRepository {
    const val FULL_NAME = "UMM-E-AIMEN"
    const val FORMATTED_NAME = "Umm-e-Aimen"
    const val ROLE_TITLE = "Software Engineering Student"
    const val LOCATION = "Lahore, Pakistan"
    const val EMAIL = "ummeaimen368@gmail.com"
    const val UNIVERSITY = "COMSATS University Islamabad, Lahore Campus"
    const val DEGREE_SHORT = "BS Software Engineering (3rd Sem)"
    const val CGPA = "3.17"
    const val GRADUATION_YEAR = "2029"

    const val OBJECTIVE =
        "Motivated Software Engineering student with a strong interest in web development and software engineering, seeking an internship to apply foundational knowledge in Java OOP, C++ DSA, React Native, and web technologies. Eager to learn, contribute, and grow within a professional development environment."

    const val HERO_INTRO =
        "I'm Umm-e-Aimen, a Software Engineering student at COMSATS University Islamabad, exploring web development, backend engineering, AI and problem solving."

    const val ABOUT_LEAD =
        "I am a Software Engineering student with a growing foundation in programming, data structures, object-oriented programming, mobile development and frontend web technologies."

    const val ABOUT_PARAGRAPH =
        "My projects range from JavaFX games and C++/SFML systems to React Native apps and responsive HTML/CSS/JavaScript websites. I enjoy understanding how things work, then turning that understanding into something functional."

    val COMPETENCIES = listOf(
        "Attention to Detail",
        "Problem Solving",
        "Teamwork",
        "Eagerness to Learn",
        "Adaptability"
    )

    val SKILL_GROUPS = listOf(
        SkillGroup(
            title = "Programming",
            iconSymbol = "⌘",
            tags = listOf("Java", "C++", "OOP", "DSA")
        ),
        SkillGroup(
            title = "Web",
            iconSymbol = "⌁",
            tags = listOf("HTML", "CSS", "JavaScript")
        ),
        SkillGroup(
            title = "Mobile",
            iconSymbol = "◈",
            tags = listOf("React Native", "State Management")
        ),
        SkillGroup(
            title = "Problem Solving",
            iconSymbol = "◎",
            tags = listOf("BFS", "DFS", "A*", "Data Structures")
        ),
        SkillGroup(
            title = "Tools",
            iconSymbol = "▣",
            tags = listOf("Git/GitHub", "MS Word", "PowerPoint")
        ),
        SkillGroup(
            title = "Currently learning",
            iconSymbol = "↗",
            tags = listOf("MERN Stack", "Backend Development", "AI"),
            isHighlighted = true
        )
    )

    val SKILLS = listOf(
        SkillItem(
            name = "Java",
            description = "Basic OOP concepts (classes, objects, inheritance, encapsulation)",
            category = "Languages & OOP",
            iconName = "Code"
        ),
        SkillItem(
            name = "C++",
            description = "Basic programming and console application development",
            category = "Languages & OOP",
            iconName = "Terminal"
        ),
        SkillItem(
            name = "DSA",
            description = "Fundamental understanding of data structures and algorithms",
            category = "CS Foundations",
            iconName = "AccountTree"
        ),
        SkillItem(
            name = "React Native",
            description = "Basic concepts of cross-platform mobile app development",
            category = "Mobile & Web",
            iconName = "PhoneAndroid"
        ),
        SkillItem(
            name = "HTML",
            description = "Create web page structure and markup",
            category = "Mobile & Web",
            iconName = "Web"
        ),
        SkillItem(
            name = "MS Office",
            description = "Proficient in Word, and PowerPoint",
            category = "Productivity Tools",
            iconName = "Description"
        )
    )

    val PROJECTS = listOf(
        ProjectItem(
            id = "trapscape",
            number = "01",
            title = "TRAPSCAPE",
            techStack = "C++, SFML",
            category = "C++ / SFML",
            visualSymbol = "⌗",
            bullets = listOf(
                "A maze-based survival game built in C++ with SFML.",
                "Custom data structures and algorithms including Stack, Queue, Linked List, BFS, DFS, and A* pathfinding for intelligent AI movement.",
                "Dynamic maze generation, authentication system, leaderboard, coin collection, and 2D graphical rendering."
            ),
            tags = listOf("Stack", "Queue", "Linked List", "BFS", "DFS", "A*"),
            keyFeatures = listOf(
                "Stack, Queue, Linked List data structures",
                "BFS, DFS and A* pathfinding AI movement",
                "Dynamic maze generation",
                "Authentication and leaderboard",
                "Coin collection and SFML graphics"
            )
        ),
        ProjectItem(
            id = "mystery_maze",
            number = "02",
            title = "Mystery Maze",
            techStack = "Java, JavaFX",
            category = "Java / JavaFX",
            visualSymbol = "▦",
            bullets = listOf(
                "A GUI-based maze game built with Java and JavaFX, designed to practice object-oriented programming in an interactive application.",
                "Designed interactive player navigation, game logic, and graphical interface applying inheritance and abstraction."
            ),
            tags = listOf("Java", "JavaFX", "OOP", "Inheritance", "Abstraction"),
            keyFeatures = listOf(
                "JavaFX graphical user interface",
                "Inheritance and abstraction architecture",
                "Interactive player navigation system",
                "Game logic and state control"
            )
        ),
        ProjectItem(
            id = "gpa_predictor",
            number = "03",
            title = "GPA Security Zone Predictor",
            techStack = "React Native",
            category = "React Native",
            visualSymbol = "◎",
            bullets = listOf(
                "A two-screen React Native application where a student enters previous GPA and study hours, then receives a prediction about their GPA security zone.",
                "Clean input handling, responsive state calculations, and actionable outcome feedback."
            ),
            tags = listOf("React Native", "State", "UI", "Mobile"),
            keyFeatures = listOf(
                "Two-screen navigation flow",
                "Input handling for previous GPA and study hours",
                "GPA security zone prediction feedback",
                "React state-driven updates"
            )
        ),
        ProjectItem(
            id = "todo_list",
            number = "04",
            title = "To-Do List App",
            techStack = "React Native",
            category = "React Native",
            visualSymbol = "✓",
            bullets = listOf(
                "A cross-platform React Native task manager focused on simple, practical state-driven UI interactions.",
                "Supports adding tasks, completing tasks, deleting tasks, state management, and real-time list rendering."
            ),
            tags = listOf("React Native", "State Management", "Task List", "Cross-Platform"),
            keyFeatures = listOf(
                "Add, complete, and delete tasks",
                "State management and real-time list rendering",
                "Cross-platform responsive design"
            )
        ),
        ProjectItem(
            id = "counter_web",
            number = "05",
            title = "Counter Web App",
            techStack = "HTML, CSS, JS",
            category = "Web",
            visualSymbol = "01",
            bullets = listOf(
                "A responsive browser-based counter created with HTML, CSS, and JavaScript.",
                "Demonstrates clean web page structure, styling, DOM interaction, and JavaScript functionality."
            ),
            tags = listOf("HTML", "CSS", "JavaScript", "DOM"),
            keyFeatures = listOf(
                "Web page structure and semantic markup",
                "CSS styling and responsive layout",
                "DOM interaction and JavaScript functionality"
            )
        ),
        ProjectItem(
            id = "calculator_web",
            number = "06",
            title = "Calculator",
            techStack = "HTML, CSS, JS",
            category = "Web",
            visualSymbol = "+",
            bullets = listOf(
                "A basic functional calculator for everyday arithmetic operations using vanilla web technologies.",
                "Features HTML structure, CSS interface, and JavaScript calculation logic."
            ),
            tags = listOf("HTML", "CSS", "JavaScript", "Math Logic"),
            keyFeatures = listOf(
                "Everyday arithmetic operations",
                "HTML structure and CSS interface",
                "JavaScript calculation logic"
            )
        ),
        ProjectItem(
            id = "snake_game",
            number = "07",
            title = "Snake Game",
            techStack = "C++",
            category = "C++",
            visualSymbol = "⚑",
            bullets = listOf(
                "Built a console-based Snake Game in C++ implementing core principles such as Loops, Arrays, and Conditional statements.",
                "Applied basic DSA concepts for movement tracking and collision detection logic."
            ),
            tags = listOf("C++", "Console", "DSA", "Arrays", "Collision"),
            keyFeatures = listOf(
                "Console game loop with responsive input",
                "Movement tracking using array structures",
                "Real-time collision detection logic"
            )
        )
    )

    val EDUCATION = listOf(
        EducationItem(
            degree = "BS Software Engineering",
            institution = "COMSATS University Islamabad, Lahore Campus",
            period = "Feb 2025 – Feb 2029",
            statusOrScore = "3rd Semester",
            isOngoing = true
        ),
        EducationItem(
            degree = "HSSC (ICS-Physics)",
            institution = "Unique College for Girls 109-A",
            period = "2022 – 2024",
            statusOrScore = "80%",
            isOngoing = false
        )
    )

    val COURSES_CERTIFICATIONS = listOf(
        CertificationItem(
            title = "MERN Stack Web Development",
            issuerOrProgram = "Hunarmand Punjab IT Program",
            note = "Just started"
        ),
        CertificationItem(
            title = "MS Office Specialist",
            issuerOrProgram = "Word, Excel, PowerPoint",
            note = "Proficient"
        )
    )

    val ACHIEVEMENTS = listOf(
        AchievementItem(
            title = "1st Position in Physics Exhibition",
            context = "Physics Exhibition Project",
            highlight = "Awarded 1st Position for building a functional Pulse Motor model."
        ),
        AchievementItem(
            title = "80% Academic Score in HSSC (ICS-Physics)",
            context = "Unique College for Girls 109-A (2022 – 2024)",
            highlight = "Achieved an outstanding 80% overall score in Intermediate Computer Science with Physics."
        )
    )
}
