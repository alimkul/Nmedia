package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository

class PostRepositoryInMemoryImpl: PostRepository {
    private var post= Post(
        id = 1,
        author = "Нетология. Университет интернет-профессии будушего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интесивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике",
        published = "21 мая в 18:36",
        likesCount = 119999, likedByMe = false, sharesCount = 89999, viewCount = 221999
    )
    private val data= MutableLiveData(post)

    override fun get(): LiveData<Post> =data
    override fun like() {
        post=post.copy(likedByMe=!post.likedByMe)
        data.value=post

    }
}