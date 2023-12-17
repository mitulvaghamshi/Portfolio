//
//  RepoDetails.swift
//  Portfolio
//
//  Created by Mitul Vaghamshi on 2023-06-12.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI
import Shared

struct EduDetails: View {
    let college: Education

    var body: some View {
        List {
            Image(college.name)
                .resizable()
                .cornerRadius(4)
                .frame(height: 200)
            EduListItem(title: college.name)
            Section(header: Text("Education Details")) {
                Label("\(college.year) - (\(college.duration))", systemImage: "calendar")
                Label(college.major, systemImage: "graduationcap")
                Label(college.address, systemImage: "location")
            }
            Section(header: Text("Website")) {
                Link(destination: URL(string: college.url)!) {
                    Label(college.url, systemImage: "link")
                        .font(.callout)
                }
            }
        }
        .navigationTitle("Details")
    }
}

#Preview {
    NavigationView {
        EduDetails(college: Common.shared.educations.first!)
    }
}
