package models

data class UserData(
    var fullname: String? = null,
    var dob: String? = null,
    var phone: String? = null,
    var image_uri: String? = null,
    var authStatus:Boolean? = null,
    var message:String? = null,
    var email:String?=null,
    var username:String?=null
)
