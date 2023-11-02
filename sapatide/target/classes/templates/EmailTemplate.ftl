<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to MyApp</title>
</head>
<body>
    <table
        align="center"
        border="0"
        cellpadding="0"
        cellspacing="0"
        width="600"
        style="border-collapse: collapse; border: 1px solid #ddd;"
    >
        <tr>
            <td style="padding: 20px 0; text-align: center; background-color: #007BFF; color: #fff;">
                <h1>User Registration information</h1>
            </td>
        </tr>
        <tr>
            <td style="padding: 20px;">
                <p>Hello, ${username}!</p>
                <p>Welcome to Sapatide. Your account has been successfully created.</p>
                <p>Below are your one time login details:</p>
                <p>
                    <strong>Username:</strong> ${email}<br>
                    <strong>Password:</strong> ${password}
                </p>
                <p>Make sure to keep your login details secure.</p>
                <p>Get started with our exciting features and services today.</p>
                <p>Best regards,<br/>The Sapatide Team</p>
            </td>
        </tr>
        <tr>
            <td style="padding: 20px; background-color: #f4f4f4; text-align: center;">
                <p>&copy; ${currentYear} Sapatide. All rights reserved.</p>
            </td>
        </tr>
    </table>
</body>
</html>
