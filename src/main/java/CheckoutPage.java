import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.util.IdentityHashMap;

import static org.junit.Assert.assertEquals;


public class CheckoutPage extends BasePage {

    private WebDriverWait wait;
    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);

    }
    @FindBy(xpath = ("//a[text()='Food']"))
    private WebElement foodMenu;

    @FindBy(css = ".btn-cart:nth-child(1) > span > span")
    private WebElement addToCart;

    @FindBy(id ="city")
    private WebElement cityCart;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id ="region_id")
    public  WebElement cartRegionDropdown;

    @FindBy(id= ("region_id"))
    public WebElement cartRegionID;

    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom button")
    private WebElement checkoutButton;

    @FindBy(id = ("onepage-guest-register-button"))
    private WebElement guestRegisterButton;

    @FindBy(id =("billing:firstname"))
    public WebElement firstnameField;

    @FindBy(css =("ul:nth-child(2) .name-lastname"))
    public WebElement lastnameField;

    @FindBy(id = ("billing:firstname"))
    public WebElement billingFirstname;

    @FindBy(id = ("billing:middlename"))
    private WebElement billingMiddlename;

    @FindBy(id = ("billing:lastname"))
    public WebElement billingLastname;

    @FindBy(id = ("billing:company"))
    private WebElement billingCompany;

    @FindBy(id = ("billing:email"))
    private WebElement billingEmail;

    @FindBy(id = ("billing:street1"))
    public WebElement street;

    @FindBy(id = ("billing:street2"))
    private WebElement secondStr;

    @FindBy(id = ("billing:city"))
    public WebElement billingCity;

    @FindBy(id = ("billing:region_id"))
    private WebElement billingRegion;

    @FindBy(id = ("billing:region_id"))
    public WebElement billingRegionDropdown;

    @FindBy(id = ("billing:postcode"))
    public WebElement billingPostcode;

    @FindBy(id = ("billing:telephone"))
    public WebElement telephone;

   @FindBy(css = ("#billing-buttons-container button"))
   public WebElement billingButtonContinue;

   @FindBy(css = ("#shipping-method-buttons-container button"))
   public WebElement shippingButtonContinue;

   @FindBy(css = ("#payment-buttons-container button"))
   public WebElement paymentButtonContinue;

   @FindBy(css = (".btn-checkout"))
   public WebElement checkoutButtonContinue;

   @FindBy(xpath = "//div[@class= 'page-title']")
   public  WebElement pageTitle;

    @FindBy(id = "advice-required-entry-billing:firstname")
    public WebElement mandatoryFirstName;

    @FindBy(id ="advice-required-entry-billing:lastname")
    public WebElement mandatoryLastName;

    @FindBy(id = "advice-required-entry-billing:street1")
    public  WebElement mandatoryStreet;

    @FindBy(id ="advice-required-entry-billing:city")
    public WebElement mandatoryCity;

    @FindBy(id ="advice-validate-select-billing:region_id")
    public WebElement mandatoryRegion;

    @FindBy(id = "advice-required-entry-billing:postcode")
    public  WebElement mandatoryPostcode;

    @FindBy(id = "advice-required-entry-billing:telephone")
    public WebElement mandatoryPhoneNumber;




    public void getFoodMenu() {
        foodMenu.click();
    }

    public void getAddToCart() {
        addToCart.click();
    }

    public void getCityCart() {
        cityCart.sendKeys("alabama");
    }

    public void setPostCode(String PostCode) {
        postcode.sendKeys(PostCode);
    }
    public void clickCartRegionDropdown() {
        cartRegionDropdown.click();
    }

    public void selectCartRegionID(String cartRegionName) {
        Select cartRegionSelect = new Select (cartRegionDropdown);
        cartRegionSelect.selectByVisibleText(cartRegionName);
   }

    public void clickChechoutButton() {
        checkoutButton.click();
    }

    public void clickGuestRegisterButton() {
        guestRegisterButton.click();
    }

    public void setBillingFirstname(String name) {
        billingFirstname.sendKeys(name);
    }

    public void setBillingMiddlename(String middlename){
        billingMiddlename.sendKeys(middlename);
    }

    public void setBillingLastname (String lastname){
        billingLastname.sendKeys(lastname);
    }

    public void setBillingCompany(String company){
        billingCompany.sendKeys(company);
    }

    public void setBillingEmail(String email){
        billingEmail.sendKeys(email);
    }

    public void setStreet(String street1){
        street.sendKeys(street1);
    }

    public void setStreet2(String street2) {
        secondStr.sendKeys(street2);
    }

    public void setBillingCity(String city){
        billingCity.sendKeys(city);
    }

    public void selectBillingRegion(String regionName) {
        Select billingRegionSelect = new Select(billingRegionDropdown);
        billingRegionSelect.selectByVisibleText(regionName);
    }

    public void setBillingPostcode(String postcode){
        billingPostcode.sendKeys(postcode);
    }

    public void setTelephone(String phonenumber){
        telephone.sendKeys(phonenumber);
    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void assertTextWhenReady(WebElement locator, String expectedText){
        wait.until(ExpectedConditions.visibilityOf(locator));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        } catch (Exception e){
            System.out.println("Text not present");
        }
        assertEquals(expectedText, locator.getText());
    }

    public void fillMandatoryFieldsExcept(WebElement fieldToSkip){
        getFoodMenu();
        getAddToCart();
        completeAndSubmitCart();
        completeAllMandatoryFieldsInCheckoutPage();
        fieldToSkip.clear();
        clickWhenReady(billingButtonContinue);
    }

    public void completeAndSubmitCart(){
        getFoodMenu();
        getAddToCart();
        getCityCart();
        setPostCode("12345");
        clickCartRegionDropdown();
        selectCartRegionID("Alabama");
        clickChechoutButton();
        clickGuestRegisterButton();

    }
    public void completeAllMandatoryFieldsInCheckoutPage(){

        setBillingFirstname("Test");
        setBillingMiddlename("Test2");
        setBillingLastname("Test3");
        setBillingCompany("Test5");
        setBillingEmail("asdf@example.com");
        setStreet("adresa mea");
        setStreet2("adresa mea 2");
        setBillingCity("Alabama City");
        selectBillingRegion("Alabama");
        setBillingPostcode("12345");
        setTelephone("0777777777");


    }
    public void clickAllContinueButtonsOnCheckoutPage(){
        clickWhenReady(billingButtonContinue);
        clickWhenReady(shippingButtonContinue);
        clickWhenReady(paymentButtonContinue);
        clickWhenReady(checkoutButtonContinue);

    }



}