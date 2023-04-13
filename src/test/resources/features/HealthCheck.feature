@ui   @HealthCheck

Feature:E-Commerce Website Health Check

Background: Browserminvokation
Given User navigate to landing page

@Landingpagevalidation
Scenario: User visit the landing page
Given User User validate the title

@Searchproductvalidation
Scenario: User search the product
Given User search the product "majestic solitaire diamond ring"
When User Validate the product from the suggest name

@NxtPageValidation
Scenario: User select the product
Given User search the product "majestic solitaire diamond ring" 
When User validate product page title
Then Select the size of the product from the drop down "22"

@FooterLink
Scenario: User validate the footer links
Given User scroll down the landing page to About Us section
When Under about us category below options are visible
|  About Our Company      |
|  Terms and Conditions   |
|  Privacy Policy         |
|  FAQ                    |
|  Offers T&Cs            |
|  Customer Reviews       |

@SocialMediaHandles
Scenario Outline: User Validate the FollowUs section
Given User scroll down the landing page to Follow Us section
When User validate the below media handles in FollowUs section "<media_handles>"
Examples: 
|media_handles|
|Facebook     |
|Instagram    |
|Twitter      |