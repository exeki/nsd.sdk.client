package tests.fetchAndWrite

import ru.ekazantsev.nsd_sdk_client.MetainfoUpdateService

import static tests.TestUtils.*

//Set<String> metaCodes = ["serviceCall", "employee", "task", "ou", 'agreement', 'team', 'root', 'slmService']
MetainfoUpdateService writer = new MetainfoUpdateService(connectorParams, db)
writer.fetchMeta()