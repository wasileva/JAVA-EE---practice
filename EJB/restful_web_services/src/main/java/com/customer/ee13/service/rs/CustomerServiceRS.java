
package com.customer.ee13.service.rs;

import com.customer.ee13.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/customers")
public class CustomerServiceRS {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers(){
        return Response.ok(getCustomerList()).build();
    }
    
    @DELETE
    @Path("{customerId}")
    public Response deleteCustomer(@PathParam("customerId") String id){
        System.out.println("deleteCustomer.id = " + id);
        return Response.ok().build();
    }
    
    private List<Customer> getCustomerList(){
        List<Customer> customers = new ArrayList<>();       
        customers.add(new Customer("1005", "Vlad", "Vasilev"));
        customers.add(new Customer("3008", "Lev","Vasilev"));      
        return customers;
        
    }
}
