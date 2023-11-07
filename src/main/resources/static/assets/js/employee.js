
$('document').ready(function (){

    $('table #editButton').on('click', function (event){
        event.preventDefault();

        // /countries/findById/?id=1
        let href = $(this).attr('href');
        $.get(href, function (employee, status){
            $('#txtAddressEdit').val(employee.address);
            $('#txtUsernameEdit').val(employee.username);
            $('#txtCityEdit').val(employee.city);
            $('#ddlNationalityEdit').val(employee.countryid);

            let dob = employee.dateOfBirth.substr(0,10);
            $('#txtDateOfBirthEdit').val(dob);
            $('#txtEmailEdit').val(employee.email);
            $('#txtFirstnameEdit').val(employee.firstname);
            $('#ddlGenderEdit').val(employee.gender);
            $('#txtIdEdit').val(employee.id);
            $('#txtInitialsEdit').val(employee.initials);
            $('#txtLastnameEdit').val(employee.lastname);
            $('#ddlMaritalStatusEdit').val(employee.maritalStatus);
            $('#txtMobileEdit').val(employee.mobile);
            $('#txtOthernameEdit').val(employee.othername);
            $('#txtPhoneEdit').val(employee.phone);
            $('#fupPhotoEdit').val(employee.photo);
            $('#txtSSNEdit').val(employee.socialSecurityNumber);
            $('#ddlStateEdit').val(employee.stateid);
            $('#ddlTitleEdit').val(employee.title);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);

            let hireDate = employee.hireDate.substr(0,10);
            $('#txtHireDateEdit').val(hireDate);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
            $("#editModal").modal('show');
        });

        // $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();

        let href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal('show');

        // $('#deleteModal').modal();
    });

    $('table #detailsButton').on('click',function(event) {
        event.preventDefault();

        let href= $(this).attr('href');
        $.get(href, function(employee, status){
            $('#txtIdDetails').val(employee.id);
            let dob = employee.dateOfBirth.substring(0,10);
            $('#txtDateOfBirthDetails').val(dob);
            $('#txtEmailDetails').val(employee.email);
            $('#txtFirstnameDetails').val(employee.firstname);
            $('#txtLastnameDetails').val(employee.lastname);
            $('#txtPhoneDetails').val(employee.phone);
            $('#lastModifiedByDetails').val(employee.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
            $('#detailsModal').modal('show');
        });

        // $('#detailsModal').modal();
    });

    $('.table #photoButton').on('click',function(event) {
        event.preventDefault();

        let href = $(this).attr('href');
        $('#photoModal #employeePhoto').attr('src', href);
        $('#photoModal').modal('show');
    });

    $('#uploadButton').on('click',function(event){
        let href = $(this).attr('href');

        $.post(href, function(data, status){
            console.log(data);
        });
    });

});