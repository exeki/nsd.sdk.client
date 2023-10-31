package tests

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.kazantsev.nsd.sdk.data.DbAccess
import ru.kazantsev.nsd.sdk.client.nsd_connector.FakeApiConnector
import ru.kazantsev.nsd.basic_api_connector.ConnectorParams

class TestUtils {
    static String INSTALLATION_ID = "DSO_TEST"
    static String dbPath = 'C:\\Users\\ekazantsev\\nsd_sdk\\data\\sdk_meta_store.mv.db'
    static Logger logger = LoggerFactory.getLogger(getClass())
    static ConnectorParams connectorParams = ConnectorParams.byConfigFile(INSTALLATION_ID)
    static FakeApiConnector nsdFakeApi = new FakeApiConnector(connectorParams)
    static ObjectMapper objectMapper = new ObjectMapper()
    static DbAccess db = DbAccess.createDefaultByInstallationId(INSTALLATION_ID)//new DbAccess(dbPath)
}
