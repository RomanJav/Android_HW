package by.academy.hwTomal.hw6.entity

object StudentsListData {
    val studentsList = ArrayList<Student>()
    var isChanged = false

    init {
        studentsList.add(Student(1, "Riko Flex", 23, "https://pp.userapi.com/c851032/v851032817/db48c/3RCM_gJh2ZM.jpg"))
        studentsList.add(Student(2, "Jacky Len", 24, "https://pp.userapi.com/c851032/v851032817/db427/qZ9YdJvC8nk.jpg"))
        studentsList.add(Student(3, "Pader Lopinsky", 23, "https://pp.userapi.com/c851032/v851032817/db430/tkWOqgh0MHE.jpg"))
        studentsList.add(Student(4, "Jhon Matuse", 26, "https://pp.userapi.com/c851032/v851032817/db454/CeWOVhPVuk0.jpg"))
        studentsList.add(Student(5, "Ivan Grek", 27, "https://pp.userapi.com/c851032/v851032817/db45d/wKopgISZVzM.jpg"))
        studentsList.add(Student(6, "Nino Oehara", 23, "https://pp.userapi.com/c851032/v851032817/db466/dHW72tREGO4.jpg"))
    }

    fun addStudent(student: Student) {
        studentsList.add(student)
    }

    fun deleteStudent(studentId: Int) {
        for (student in studentsList) {
            if (student.id == studentId){
                studentsList.remove(student)
                break
            }
        }
    }

    fun editStudent(studentEdit: Student) {
        for (student in studentsList) {
            if (student.id == studentEdit.id)
                studentsList[studentsList.indexOf(student)] = studentEdit
        }
    }
}