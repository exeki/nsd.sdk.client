package ru.ekazantsev.nsd_sdk_client.writers

import ru.ekazantsev.nsd_sdk_data.DbAccess
import ru.ekazantsev.nsd_sdk_data.dto.Attribute
import ru.ekazantsev.nsd_sdk_data.dto.AttributeType
import ru.ekazantsev.nsd_sdk_data.dto.MetaClass
import ru.ekazantsev.nsd_sdk_client.nsd_connector.dto.AttributeDto

/**
 * Служба, записывающая аттрибуты в хранилище
 */
class AttributeWriter (private val db: DbAccess) {
    private val dao = db.attributeDao
    fun createOrUpdate(meta: MetaClass, attrDto: AttributeDto) : Attribute {
        var attr: Attribute? = dao.queryBuilder()
            .where()
            .eq("code", attrDto.code)
            .and()
            .eq("metaClass_id", meta.id)
            .query()
            .lastOrNull()
        if (attr == null) attr = Attribute()
        val type = AttributeType.getByCode(attrDto.type)
        if (type == null) throw RuntimeException("Can find type ${attrDto.type} in enum \"AttributeType\".")
        attr.code = attrDto.code
        attr.hardcoded = attrDto.hardcoded
        attr.required = attrDto.required
        attr.requiredInInterface = attrDto.requiredInInterface
        attr.title = attrDto.title
        attr.type = type
        attr.unique = attrDto.unique
        attr.metaClass = meta
        attr.description = attrDto.description
        attr.relatedMetaClass = attrDto.relatedMetaClass
        dao.createOrUpdate(attr)
        return attr
    }
}