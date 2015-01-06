// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.cloud.api.commands;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.ApiConstants;
import org.apache.cloudstack.api.ApiErrorCode;
import org.apache.cloudstack.api.BaseAsyncCmd;
import org.apache.cloudstack.api.Parameter;
import org.apache.cloudstack.api.ServerApiException;
import org.apache.cloudstack.api.response.PhysicalNetworkResponse;
import org.apache.cloudstack.context.CallContext;

import com.cloud.api.responses.PluginMysqlResponse;
import com.cloud.event.EventTypes;
import com.cloud.exception.ConcurrentOperationException;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.InvalidParameterValueException;
import com.cloud.exception.ResourceAllocationException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.network.dao.ExternalLoadBalancerDeviceVO;
import com.cloud.utils.exception.CloudRuntimeException;

@APICommand(name = "showDbTables", responseObject = PluginMysqlResponse.class, description = "show database tables",
        requestHasSensitiveInfo = false, responseHasSensitiveInfo = false)
public class ShowDbTablesCmd extends BaseAsyncCmd {

    public static final Logger s_logger = Logger.getLogger(ShowDbTablesCmd.class.getName());
    private static final String s_name = "showdbtablesrresponse";

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////


    @Parameter(name = ApiConstants.USERNAME, type = CommandType.STRING, required = true, description = "optional value")
    private String username;

    @Parameter(name = ApiConstants.PASSWORD, type = CommandType.STRING, required = true, description = "optional value")
    private String password;


    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////


    /////////////////////////////////////////////////////
    /////////////// API Implementation///////////////////
    /////////////////////////////////////////////////////

    @Override
    public void execute() throws ResourceUnavailableException, InsufficientCapacityException, ServerApiException, ConcurrentOperationException,
        ResourceAllocationException {
        try {
        	s_logger.info("begin show database tables.");
                PluginMysqlResponse response = null;//XXXXManagerService.createLoadBalancerResponse(lbDeviceVO);
                response.setObjectName("showdbtables");
                response.setResponseName(getCommandName());
                this.setResponseObject(response);
            
        } catch (InvalidParameterValueException invalidParamExcp) {
            throw new ServerApiException(ApiErrorCode.PARAM_ERROR, invalidParamExcp.getMessage());
        } catch (CloudRuntimeException runtimeExcp) {
            throw new ServerApiException(ApiErrorCode.INTERNAL_ERROR, runtimeExcp.getMessage());
        }
    }

    @Override
    public String getEventDescription() {
        return "show database tables";
    }


    @Override
    public String getCommandName() {
        return s_name;
    }

    @Override
    public long getEntityOwnerId() {
        return CallContext.current().getCallingAccount().getId();
    }

	@Override
	public String getEventType() {
		// TODO Auto-generated method stub
		return null;
	}
}
