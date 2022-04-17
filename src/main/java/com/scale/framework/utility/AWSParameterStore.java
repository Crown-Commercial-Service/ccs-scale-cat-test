package com.scale.framework.utility;
/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * To run this Java V2 code example, ensure that you have setup your development environment, including your credentials.
 * <p>
 * For information, see this documentation topic:
 * <p>
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
public class AWSParameterStore {
    String AWSProfile;
    Region region;
    SsmClient ssmClient;

    public AWSParameterStore() {
        try {
            AWSProfile = new ConfigurationReader().get("AWSProfile");
            region = Region.EU_WEST_2;
            ssmClient = SsmClient.builder()
                    .region(region)
                    //.credentialsProvider(ProfileCredentialsProvider.create(AWSProfile))
                    .credentialsProvider(ProfileCredentialsProvider.create())
                    .build();

        } catch (SsmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public String getValue(String Key) {
        GetParameterRequest parameterRequest = GetParameterRequest.builder()
                .name(Key)
                .withDecryption(Boolean.TRUE)
                .build();

        GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
        //ssmClient.close();
        return parameterResponse.parameter().value();
    }

    public HashMap<String, String> getValuesByPath(String Path) {

        HashMap<String,String> Output = new HashMap<>();
        List<Parameter> Params = new ArrayList<>();
        String Token=null;

        while (Token!=null || Params.size()==0){
            GetParametersByPathRequest request = GetParametersByPathRequest.builder()
                    .path(Path)
                    .withDecryption(Boolean.TRUE)
                    .maxResults(10)
                    .nextToken(Token)
                    .build();
            GetParametersByPathResponse response = ssmClient.getParametersByPath(request);
            Params.addAll(response.parameters());
            Token=response.nextToken();
            if(Token==null)
            {   break;
            }
        }
        for (Parameter p : Params) {
            Output.put(p.name().replaceAll("/cat/[a-z-]*/",""),p.value());
        }
        //ssmClient.close();
        return Output;
    }

}