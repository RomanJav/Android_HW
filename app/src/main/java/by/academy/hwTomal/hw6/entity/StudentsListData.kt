package by.academy.hwTomal.hw6.entity


import by.academy.hwTomal.hw6.retrofit.provideApi
import kotlinx.coroutines.runBlocking

object StudentsListData {
    var studentsList = ArrayList<Student>()
    var isChanged = false

    fun getStudents() = runBlocking {
        studentsList = provideApi().getStudents().await()
    }

    fun addStudent(student: Student) = runBlocking{
        provideApi().addStudent(student).await()
    }

    fun deleteStudent(objectId: String)= runBlocking{
        for (student in studentsList) {
            if (student.objectId == objectId) {
                provideApi().deleteStudent(objectId).await()
                break
            }
        }
    }

    fun editStudent(studentEdit: Student) = runBlocking{
        for (student in studentsList) {
            if (student.objectId == studentEdit.objectId) {
                provideApi().editStudent(studentEdit.objectId, studentEdit).await()
                break
            }
        }
    }
}