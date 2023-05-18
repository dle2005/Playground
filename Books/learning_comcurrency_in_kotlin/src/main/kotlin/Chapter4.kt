import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

data class Profile(
    val id: Long,
    val name: String,
    val age: Int,
)

interface ProfileServiceRepository {
    suspend fun fetchByName(name: String) : Profile
    suspend fun fetchById(id: Long) : Profile
}

class ProfileServiceClient : ProfileServiceRepository {
    override suspend fun fetchByName(name: String): Profile {
        delay(1000)
        return Profile(1, name, 28)
    }

    override suspend fun fetchById(id: Long): Profile {
        delay(2000)
        return Profile(id, "Susan", 28)
    }
}

/**
 * Total time = 3018ms
 */
fun main() = runBlocking {
    val profileServiceClient = ProfileServiceClient()
    val time = measureTimeMillis {
        val profileById = profileServiceClient.fetchById(1)
        val profileByName = profileServiceClient.fetchByName("Susan")
    }
    println("Total time = ${time}ms")
}