package com.samsung.healthcare.kit.model.question

import com.samsung.healthcare.kit.model.Model

abstract class QuestionModel<R>(
    id: String,
    question: String,
    val explanation: String? = null,
    drawableId: Int? = null,
    val type: QuestionType,
    private val answer: R? = null,
) : Model(id, question, drawableId) {

    fun isCorrect(): Boolean = if (null != answer) answer == getResponse() else true

    abstract fun getResponse(): R?

    enum class QuestionType {
        Choice,
        MultipleChoice,
        Text
    }
}
