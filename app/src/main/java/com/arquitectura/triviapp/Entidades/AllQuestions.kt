package com.arquitectura.triviapp.Entidades

class AllQuestions {

    fun insertAll(): List<QuestionEntity> {

        val iList: MutableList<QuestionEntity> = mutableListOf()

        val q1 = QuestionEntity(
            id = null,
            question = "Which one of the following is not a prime number?",
            op1 = "31",
            op2 = "61",
            op3 = "71",
            op4 = "91",
            answer = "91",
            subject = "math"
        )
        val q2 = QuestionEntity(
            id = null,
            question = "What least number must be added to 1056, so that the sum is completely divisible by 23 ?",
            op1 = "2",
            op2 = "3",
            op3 = "18",
            op4 = "21",
            answer = "2",
            subject = "math"
        )
        val q3 = QuestionEntity(
            id = null,
            question = "1397 x 1397 = ?",
            op1 = "1981709",
            op2 = "1951609",
            op3 = "18362619",
            op4 = "2031719",
            answer = "1951609",
            subject = "math"
        )
        val q4 = QuestionEntity(
            id = null,
            question = "The largest 4 digit number exactly divisible by 88 is:",
            op1 = "8888",
            op2 = "9768",
            op3 = "9988",
            op4 = "9944",
            answer = "9944",
            subject = "math"
        )
        val q5 = QuestionEntity(
            id = null,
            question = "Which of the following is a prime number ?",
            op1 = "33",
            op2 = "81",
            op3 = "93",
            op4 = "97",
            answer = "97",
            subject = "math"
        )
        val q6 = QuestionEntity(
            id = null,
            question = "The percentage of irrigated land in India is about",
            op1 = "45",
            op2 = "65",
            op3 = "35",
            op4 = "25",
            answer = "35",
            subject = "geography"
        )
        val q7 = QuestionEntity(
            id = null,
            question = "What is the capital of Indian subcontinent?",
            op1 = "Berlin",
            op2 = "Delhi",
            op3 = "Chennai",
            op4 = "Stockholm",
            answer = "Delhi",
            subject = "geography"
        )
        val q8 = QuestionEntity(
            id = null,
            question = "The state having a largest area of forest cover in India is",
            op1 = "Arunachal Pradesh",
            op2 = "Haryana",
            op3 = "Madhya Pradesh",
            op4 = "Assam",
            answer = "Madhya Pradesh",
            subject = "geography"
        )
        val q9 = QuestionEntity(
            id = null,
            question = "The oldest mountains in India are :",
            op1 = "Aravalis",
            op2 = "Vindhyas",
            op3 = "Satpuras",
            op4 = "Nilgiri Hills",
            answer = "Aravalis",
            subject = "geography"
        )
        val q10 = QuestionEntity(
            id = null,
            question = "Which country has the highest population?",
            op1 = "India",
            op2 = "Japan",
            op3 = "China",
            op4 = "Shillong",
            answer = "China",
            subject = "geography"
        )

        val q11 = QuestionEntity(
            id = null,
            question = "Mark Twain wrote about which of these characters?",
            op1 = "Little boy blue",
            op2 = "Dennis the menace",
            op3 = "Red riding hood",
            op4 = "Tom sayer",
            answer = "Tom sayer",
            subject = "literature"
        )
        val q12 = QuestionEntity(
            id = null,
            question = "Who wrote \"To Kill a Mockingbird\"?",
            op1 = "Dr. Seuss",
            op2 = "Harper Lee",
            op3 = "Ronald Reagen",
            op4 = "John Lennon",
            answer = "Harper Lee",
            subject = "literature"
        )
        val q13 = QuestionEntity(
            id = null,
            question = "Which play by Shakespeare has lovers committing suicide?",
            op1 = "Romeo and Juliet",
            op2 = "Lonesome Dove",
            op3 = "Breakfast at tiffany",
            op4 = "Run rabbit run",
            answer = "Romeo and Juliet",
            subject = "literature"
        )
        val q14 = QuestionEntity(
            id = null,
            question = "Which best describes George Orwell's \"Animal Farm\"?",
            op1 = "Women/Monthly cycles",
            op2 = "Babe Ruth/Yankees",
            op3 = "Dinosaurs/Barney",
            op4 = "Animals/Communism",
            answer = "Animals/Communism",
            subject = "literature"
        )
        val q15 = QuestionEntity(
            id = null,
            question = "Which book is centered on a horse?",
            op2 = "Animal farm",
            op1 = "The Muppets",
            op3 = "Black Beauty",
            op4 = "One Flew Over the Cuckoo's Nest",
            answer = "Black Beauty",
            subject = "literature"
        )

        iList.add(q1)
        iList.add(q2)
        iList.add(q3)
        iList.add(q4)
        iList.add(q5)
        iList.add(q6)
        iList.add(q7)
        iList.add(q8)
        iList.add(q9)
        iList.add(q10)
        iList.add(q11)
        iList.add(q12)
        iList.add(q13)
        iList.add(q14)
        iList.add(q15)

        return iList
    }
}