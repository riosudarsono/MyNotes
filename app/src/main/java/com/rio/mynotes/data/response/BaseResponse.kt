package com.rio.mynotes.data.response

class BaseResponse<T>(
    var data: T,
    var status: Int,
    var message: String) {
}