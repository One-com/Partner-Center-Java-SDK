// -----------------------------------------------------------------------
// <copyright file="UserMemberOperations.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.customerdirectoryroles;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponent;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.roles.DirectoryRole;
import com.microsoft.store.partnercenter.models.utils.TripletTuple;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;
import com.microsoft.store.partnercenter.utils.StringHelper;

public class UserMemberOperations 
	extends BasePartnerComponent<TripletTuple<String, String, String>>
	implements IUserMember
{

	/***
	 * Initializes a new instance of the UserMemberOperations class.
	 * 
	 * @param rootPartnerOperations: The partner operations instance.
	 * @param customerId: Customer id.
	 * @param roleId: The directory role id.
	 * @param userId: The user id.
	 */
	public UserMemberOperations(IPartner rootPartnerOperations, String customerId, String roleId, String userId )
	{
		super(rootPartnerOperations, new TripletTuple<String, String, String>( customerId, roleId, userId ) );
		if ( StringHelper.isNullOrEmpty( customerId ) )
        {
            throw new IllegalArgumentException("customerId must be set.");
        }

        if ( StringHelper.isNullOrEmpty( roleId ) )
        {
            throw new IllegalArgumentException("roleId must be set.");
        }

        if ( StringHelper.isNullOrEmpty( userId ) )
        {
            throw new IllegalArgumentException("userId must be set.");
        }
	}

	/***
	 * Remove directory user member from directory role.
	 */
	@Override
	public void delete()
	{
        IPartnerServiceProxy<DirectoryRole, DirectoryRole> partnerServiceProxy =
                new PartnerServiceProxy<DirectoryRole, DirectoryRole>( new TypeReference<DirectoryRole>()
                {
                }, this.getPartner(), MessageFormat.format( PartnerService.getInstance().getConfiguration().getApis().get( "RemoveCustomerUserMemberFromDirectoryRole" ).getPath(),
        				this.getContext().getItem1(), this.getContext().getItem2(), this.getContext().getItem3(), Locale.US ) );

        partnerServiceProxy.delete();
        return;
    }

}
