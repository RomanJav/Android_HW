package by.academy.hwTomal.hw6.retrofit

import by.academy.hwTomal.hw6.entity.Student
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface StudentApi {

    @GET("students")
    fun getStudents(): Deferred<ArrayList<Student>>

    @PUT("students/{objectId}")
    fun editStudent(@Path("objectId") objectId: String, @Body student: Student): Deferred<Unit>

    @POST("students")
    fun addStudent(@Body student: Student): Deferred<Unit>

    @DELETE("students/{objectId}")
    fun deleteStudent(@Path("objectId") objectId: String): Deferred<Unit>
}