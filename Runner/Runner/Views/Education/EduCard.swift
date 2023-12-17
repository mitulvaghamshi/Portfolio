//
//  EduCard.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2023-06-15.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI
import Shared

struct EduCard: View {
    var body: some View {
        NavigationView {
            List {
                Section("Educational Background") {
                    ForEach(Common.shared.educations) { college in
                        NavigationLink(destination: EduDetails(college: college)) {
                            EduListItem(title: college.name)
                        }
                    }
                }
                Section("Degree Evaluation") {
                    NavigationLink(destination: WesDetails()) {
                        EduListItem(title: "Degree Evaluation")
                    }
                }
                Section("Flutter Clock Challange") {
                    NavigationLink(destination: Certificate()) {
                        Label("Certificate", systemImage: "rosette")
                    }
                    NavigationLink(destination: Credential()) {
                        Label("Credential", systemImage: "rosette")
                    }
                }
                Section("College Id Card") {
                    NavigationLink(destination: MohawkStudentId()) {
                        Label("Mohawk Student ID", systemImage: "rosette")
                    }
                }
            }
            .navigationTitle("Education")
        }
    }
}

extension Education: Identifiable {}

#Preview {
    EduCard()
}
