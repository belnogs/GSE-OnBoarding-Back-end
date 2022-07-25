package com.liferay.content.setup.helper;

import com.liferay.object.model.ObjectField;
import com.liferay.object.model.ObjectFieldSetting;
import com.liferay.object.service.ObjectFieldLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, service = ObjectHelper.class)
public class ObjectHelper {

      public ObjectField addCustomObjectField(
                long userId, long listTypeDefinitionId, long objectDefinitionId,
                String businessType, String dbType, boolean indexed,
                boolean indexedAsKeyword, String indexedLanguageId,
                Map<Locale, String> labelMap, String name, boolean required,
                List<ObjectFieldSetting> objectFieldSettings)
                throws PortalException {
            
         labelMap = new HashMap<>();
         labelMap.put(LocaleUtil.getDefault(), name);

        return _objectFieldLocalService.addCustomObjectField(userId, listTypeDefinitionId, objectDefinitionId,
            businessType, dbType, indexed,
            indexedAsKeyword, indexedLanguageId,
            labelMap, name, required, objectFieldSettings);

        }

    @Reference
    private ObjectFieldLocalService _objectFieldLocalService;


}


