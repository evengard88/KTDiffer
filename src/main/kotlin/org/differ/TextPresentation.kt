package org.differ

class TextPresentation(
        val text: String?,
        val children: List<TextPresentation>,
        val bulletCount: BulletCount
) {

}

sealed class BulletCount {

}
