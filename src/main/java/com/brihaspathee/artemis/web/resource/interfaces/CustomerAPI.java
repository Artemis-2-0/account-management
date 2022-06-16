package com.brihaspathee.artemis.web.resource.interfaces;

import com.brihaspathee.artemis.domain.security.User;
import com.brihaspathee.artemis.permissions.AccountReadPermission;
import com.brihaspathee.artemis.permissions.CustomerReadPermission;
import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.AccountSet;
import com.brihaspathee.artemis.web.model.CustomerDto;
import com.brihaspathee.artemis.web.model.CustomerSet;
import com.brihaspathee.artemis.web.response.ArtemisApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:28 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.resource.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/customer")
@Validated
public interface CustomerAPI {

    /**
     * Get the customer related to the customer sk that is passed in as input
     * @param customerSK
     * @return
     */
    @Operation(
            method = "GET",
            description = "Get the details of the customer by its id",
            tags = {"customer"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the details of the customer",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ArtemisApiResponse.class))
                            }
                    )
            }
    )
    @AccountReadPermission
    @GetMapping("/{customerSK}")
    ResponseEntity<ArtemisApiResponse<CustomerDto>> getCustomerById(@PathVariable("customerSK") String customerSK);

    /**
     * Get all the customers
     * @return CustomerSet
     *
     */
    @Operation(
            method = "GET",
            description = "Get the details of all the customer",
            tags = {"customer"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the details of all the customer",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ArtemisApiResponse.class))
                            }
                    )
            }
    )
    @AccountReadPermission
    @GetMapping()
    ResponseEntity<ArtemisApiResponse<CustomerSet>> getCustomer(@AuthenticationPrincipal User user);
}
