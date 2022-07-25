package com.liferay.content.setup.upgrade;

import com.liferay.content.setup.helper.ObjectHelper;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateObjectUpgradeProcess extends UpgradeProcess {
    public CreateObjectUpgradeProcess(ObjectHelper objectHelper) {
        this._objectHelper = objectHelper;
    }

    @Override
    protected void doUpgrade() throws Exception {

     _objectHelper.addCustomObjectField(
             38410,
             41232,
             41241,
             "Text",
             "String",
             true,
             false,
             "en_US",
             new HashMap<>(),
             "objectUpgradeProcess",
              true,
             new ArrayList<>());
    }
    private ObjectHelper _objectHelper;
    private UserLocalService _userLocalService;
    private Portal _portal;
}
