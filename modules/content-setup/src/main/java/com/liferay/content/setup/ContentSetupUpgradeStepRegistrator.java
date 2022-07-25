package com.liferay.content.setup;


import com.liferay.content.setup.helper.ObjectHelper;
import com.liferay.content.setup.helper.SampleSiteSetupHelper;
import com.liferay.content.setup.upgrade.CreateObjectUpgradeProcess;
import com.liferay.content.setup.upgrade.CreateSampleSiteUpgradeProcess;
import com.liferay.portal.kernel.upgrade.DummyUpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        registry.register("0.0.0","1.0.0", new DummyUpgradeProcess());
        registry.register("1.0.0","1.1.0", new CreateSampleSiteUpgradeProcess(_sampleSiteSetupHelper));
        registry.register("1.1.0","1.2.0", new CreateObjectUpgradeProcess(_objectHelper));
    }

    @Reference
    private SampleSiteSetupHelper _sampleSiteSetupHelper;

    @Reference
    private ObjectHelper _objectHelper;
}
