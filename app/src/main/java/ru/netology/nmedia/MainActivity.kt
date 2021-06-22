package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.netology.nmedia.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)// названия нашего лауота
        setContentView(binding.root)

        val post = Post(
                id = 1,
                author = "Нетология. Университет интернет-профессии будушего",
                content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интесивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике",
                published = "21 мая в 18:36",
                likesCount = 2100000, likedByMe = false, sharesCount = 88777, viewCount = 221000
        )
        with(binding)
        {
            author.text = post.author
            content.text = post.content
            published.text = post.published
            sharecount.text = post.sharesCount.toString()
            if (post.likedByMe) {
                likes?.setImageResource(R.drawable.ic_liked_24)
            }
            likecount.text = checkCount(post.likesCount)

            sharecount.text = checkCount(post.sharesCount)


            likes?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                likes.setImageResource(
                        if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                if (post.likedByMe) post.likesCount++
                else post.likesCount--
                likecount.text = checkCount(post.likesCount)

            }
            share?.setOnClickListener {
                post.sharesCount++
                sharecount.text = checkCount(post.sharesCount)
            }
            viewcount.text = checkCount(post.viewCount)

        }
    }

    // сокраченное число
    fun checkCount(count: Int): String {
        var text: String =""

        if (count >= 10000 && count < 1000000) {
            if (count % 10000 > 1000)
                text = "${myRound(count.toDouble() / 1000)}K"
            else
                text = "${myRound(count / 1000.0).toInt()}K"
        }
        else if(count>=1000000){
            if (count % 1000000>100000) {
            text = "${myRound(count.toDouble() / 1000000)}M"
            } else {
                text = "${myRound(count / 1000000.0).toInt()}M"
            }
        }
        else{
            text=count.toString()
        }

        return text
    }
    //сократить дробное число до 1/10
    fun myRound(count: Double): Double {
        return Math.round(count * 10.0) / 10.0
    }
}

