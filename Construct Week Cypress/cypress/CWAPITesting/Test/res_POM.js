import resAPI from "../../support/Page Objects/RestAPI";
describe('Rest API Example ', () => {
    let burl = "https://dummy.restapiexample.com/public/api/v1";
    let CW = new resAPI

    it('Get All Employees', () => {
        CW.get_all("GET",burl,"/employees")
        cy.wait(3000);
        
    });


    it('Get Employee', () => {
        CW.get_emp("GET",burl,"/employee/1")
        cy.wait(3000);

    });


    it('Create', () => {
        CW.create("POST",burl,"/create",{
            "name":"test",
            "salary":"123",
            "age":"23"
        })
        cy.wait(2000);

        
    });

    it('Update', () => {
        CW.update("PUT",burl,"/update/21",{
            "name":"test",
            "salary":"123",
            "age":"23"
        })
        cy.wait(2000);

        
    });


    it('delete', () => {
        CW.delete("DELETE",burl,"/delete/2")
        cy.wait(2000);

        
    });




//dnt    
});