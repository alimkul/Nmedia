package ru.netology.nmedia

data class Post(
    val id:Long,
    val author:String,
    val content:String,
    val published:String,
    var likesCount:Int,
    var likedByMe:Boolean=false,
    var sharesCount:Int,
    var viewCount:Int
) {
}