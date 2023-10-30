package tests.fetchAndWrite

import ru.kazantsev.nsd.sdk.client.MetainfoUpdateService

import static tests.TestUtils.*

Set<String> metaCodes = ["orderLine"]
MetainfoUpdateService writer = new MetainfoUpdateService(connectorParams, db)
writer.fetchMeta(metaCodes)