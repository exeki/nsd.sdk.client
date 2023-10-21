package tests

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.ekazantsev.nsd_sdk_data.DbAccess
import ru.ekazantsev.nsd_sdk_client.nsd_connector.FakeApiConnector
import ru.ekazantsev.nsd_basic_api_connector.ConnectorParams

class TestUtils {
    static String dbPath = 'C:\\Users\\ekazantsev\\nsd_sdk\\data\\sdk_meta_store.mv.db'
    static Logger logger = LoggerFactory.getLogger(getClass())
    static ConnectorParams connectorParams = ConnectorParams.byConfigFile("DSO_TEST")
    static FakeApiConnector nsdFakeApi = new FakeApiConnector(connectorParams)
    static ObjectMapper objectMapper = new ObjectMapper()
    static DbAccess db = new DbAccess(dbPath)
}
