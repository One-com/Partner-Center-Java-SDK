// -----------------------------------------------------------------------
// <copyright file="IPartnerProfileCollection.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.profiles;

import com.microsoft.store.partnercenter.IPartnerComponentString;

/**
 * Represents the behavior of a partner's profiles.
 */
public interface IPartnerProfileCollection
    extends IPartnerComponentString
{
    /**
     * Gets the operations available for the legal business profile.
     */
    ILegalBusinessProfile getLegalBusinessProfile();

    /**
     * Gets the operations available for the partner network profile.
     */
    IMpnProfile getMpnProfile();

    /**
     * Gets the operations available for the partner support profile.
     */
    ISupportProfile getSupportProfile();

    /**
     * Gets the operations available for the organization profile.
     */
    IOrganizationProfile getOrganizationProfile();

    /**
     * Gets the operations available for the partner billing profile.
     */
    IBillingProfile getBillingProfile();

}
