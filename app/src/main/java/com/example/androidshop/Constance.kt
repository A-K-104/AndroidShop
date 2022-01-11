package com.example.androidshop

class Constance {
    object LogMessages {
        const val ERROR_GET_URL = "That didn't work!"
        const val ERROR_GET_IMAGE_URL = "project_close"
    }

    object HTTP {
        const val BASE_URL = "https://dev-api.com/fruitsBT/getFruits"
    }

    object IntentDataHeaders {
        const val PRODUCTS_JSON = "products_json"
        const val SINGLE_PRODUCT = "product_CLASS"
    }

    object JsonHeaders {
        const val DATA_MAIN_HEADER = "fruits"
        const val PRODUCT_NAME_HEADER = "name"
        const val PRODUCT_DESCRIPTION_HEADER = "description"
        const val PRODUCT_IMAGE_LINK_HEADER = "image"
        const val PRODUCT_PRICE_HEADER = "price"
    }

    object ImagesSizes {
        const val BIG_IMAGE_ICON = 384
        const val SMALL_IMAGE_BOX_WIDTH = 160
        const val SMALL_IMAGE_BOX_HEIGHT = 96
    }
    object XmlString {
        const val PRODUCT_PRICE= "Price:"
    }
}