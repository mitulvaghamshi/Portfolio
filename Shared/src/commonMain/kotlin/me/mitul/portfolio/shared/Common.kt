package me.mitul.portfolio.shared

import me.mitul.portfolio.github.GitHubRepo

object Common {
    val educations by lazy {
        listOf(
            Education(
                id = 0,
                duration = "2 years",
                year = "2020 - 2021",
                name = "Mohawk College",
                major = "Computer System Technician",
                url = "https://www.mohawkcollege.ca",
                address = "Hamilton, Ontario, Canada.",
            ),
            Education(
                id = 1,
                duration = "3 years",
                year = "2014 - 2017",
                name = "Amrut Institute",
                major = "Diploma in Computer Engineering",
                url = "https://www.aij.ind.in",
                address = "Junagadh, Gujarat, India.",
            ),
        )
    }

    val socialLinks by lazy {
        listOf(
            Triple(
                first = 0,
                second = "Gmail",
                third = "mailto:mitulvaghmashi@gmail.com",
            ),
            Triple(
                first = 1,
                second = "GitHub",
                third = "https://github.com/mitulvaghamshi",
            ),
            Triple(
                first = 2,
                second = "LinkedIn",
                third = "https://www.linkedin.com/in/mitulvaghamshi",
            ),
            Triple(
                first = 3,
                second = "WhatsApp",
                third = "https://api.whatsapp.com/send?phone=12899330783",
            ),
            Triple(
                first = 4,
                second = "Phone",
                third = "tel:12899330783",
            ),
        )
    }

    val externalLinks by lazy {
        val host = "https://mitulvaghamshi.github.io"
        listOf(
            Pair(
                first = "Download Resume",
                second = "$host/static/resume.pdf",
            ),
            Pair(
                first = "Portfolio app (Flutter Web)",
                second = host,
            ),
            Pair(
                first = "View Html Version",
                second = "$host/static",
            ),
            Pair(
                first = "Privacy Policy",
                second = "$host/static/policy.html",
            ),
            Pair(
                first = "Copyright © Portfolio App,\nMitul Vaghamshi, ${Utils.currentYear}.",
                second = host,
            ),
        )
    }

    val wesLinks by lazy {
        listOf(
            Pair(
                first = "Verify Evaluation",
                second = "https://www.credly.com/badges/b78c680a-1a8b-49df-a97d-cf08ef481db9",
            ),
            Pair(
                first = "Access Evaluation Report",
                second = "https://badges.wes.org/Evidence?type=ca&i=3794f10a-19b3-47f0-82bd-393315bc6584",
            ),
        )
    }

    val credentialLink by lazyOf(
        Pair(
            first = "Flutter Clock Challenge",
            second = "https://www.credential.net/21acfbc9-04fe-462f-954e-05f20f420da1",
        )
    )

    val sampleRepo by lazyOf(
        GitHubRepo(
            id = 0,
            name = "Remarkable Repo",
            url = "https://github.com/mitulvaghamshi",
            size = 100,
            language = "Markdown",
            description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            topics = listOf("Sample", "App", "Portfolio", "Coding")
        )
    )

    const val DESCRIPTION =
        "To obtain a challenge in a professional progressing environment where my resourceful " +
                "experience and knowledge of Computer Programming, Data Analysis and Project " +
                "Management will add significant value to organizational operations."
}
