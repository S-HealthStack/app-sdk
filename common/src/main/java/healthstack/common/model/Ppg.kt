package healthstack.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import healthstack.common.util.getCurrentTimeOffset

const val PPG_GREEN_TABLE_NAME = "ppg_green"

interface PpgAttribute {
    val ppg: Int
}
sealed class Ppg : PpgAttribute
@Entity(
    tableName = PPG_GREEN_TABLE_NAME,
)
data class PpgGreen(
    @PrimaryKey override val timestamp: Long = 0,
    override val ppg: Int = 0,
    override val timeOffset: Int = getCurrentTimeOffset(),
) : Ppg(), WearData {
    override fun toDataMap(): Map<String, Any> =
        mapOf(
            ::timestamp.name to timestamp,
            ::ppg.name to ppg,
            ::timeOffset.name to timeOffset,
        )
}
