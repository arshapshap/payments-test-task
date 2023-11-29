package com.arshapshap.paymentsapp.feature.payments.data.network.response

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull

internal object AmountValueSerializer : KSerializer<AmountValue> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("AmountValue", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: AmountValue) { }

    override fun deserialize(decoder: Decoder): AmountValue {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        return when {
            element is JsonPrimitive && element.isString -> {
                AmountValue.StringAmount(element.content)
            }
            element is JsonPrimitive && element.intOrNull != null -> {
                AmountValue.IntAmount(element.int)
            }
            element is JsonPrimitive && element.doubleOrNull != null -> {
                AmountValue.DoubleAmount(element.double)
            }
            else -> {
                throw SerializationException("Unexpected JSON element for AmountValue")
            }
        }
    }
}