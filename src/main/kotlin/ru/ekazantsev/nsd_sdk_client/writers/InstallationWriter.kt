package ru.ekazantsev.nsd_sdk_client.writers

import ru.ekazantsev.nsd_sdk_data.dto.Installation
import ru.ekazantsev.nsd_basic_api_connector.ConnectorParams
import ru.ekazantsev.nsd_sdk_data.DbAccess
import java.util.Date

/**
 * Служба, записывающая инсталляции в хранилище
 */
class InstallationWriter (private val db: DbAccess) {
    private val dao = db.installationDao
    fun createOrUpdate(connectorParams: ConnectorParams) : Installation {
        var inst: Installation? = dao.queryForEq("host", connectorParams.host).lastOrNull()
        if (inst == null) inst = Installation()
        inst.host = connectorParams.host
        inst.lastUpdateDate = Date()
        inst.userId = connectorParams.userId
        dao.createOrUpdate(inst)
        return inst
    }
}