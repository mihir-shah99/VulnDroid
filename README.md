# VulnDroid - The Vulnerable Android App
    __VulnDroid__ is a *Vulnerable Android App* designed in a CTF challenge style, it focuses on learning the exploitation of Android
    vulnerabilities pertaining to Local Storage, i.e. In-The-App malpractices by the developers. This playground has a total of Eight
    levels- with more to come. The attacker will have knowledge of the victim and will send a crafted payload, to read the flag
    and enter it within the app, on entering the correct flag, the user is greeted with a Congratulations page.
    The attacker only completes the challenge on successful validation of the flag.

# Levels in the App
    1. Hardocding Details
    2. Insecure Logging
    3. Insecure Database
    4. Sensitive info in Android VCS
    5. Insecure Shared Preferences
    6. Sensitive info within function calls
    7. Insecure External Storage
    8. Insecure Internal Storage

> This also teaches the practice of secure coding. 
> The developer can observe the source code and understand that the flag value is stored in an encrypted format and only the hash of the user input flag is stored.
> The validated is also carried out only by comparing the hash values. 
> This makes the Source code quite difficult to reverse from the bundled APK. 

## Future Updates
 This App is only pertaining to the challenges and the exploitabiliy of the localstorage options. In the upcoming series of app releases, other dynamic analysis challenges would also be released. 

## Todo
1. Create more levels on for this App
2. Minor changes for the UX of the app
3. Create another app for Web hooking, Dynamic testing, etc.


[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/L4L81BEBM)
