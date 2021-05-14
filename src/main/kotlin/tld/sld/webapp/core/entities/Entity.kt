package tld.sld.webapp.core.entities

import java.sql.Timestamp
import java.util.*

interface Entity {
    val id: UUID
    val createdAt: Timestamp
    val updatedAt: Timestamp
}