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
                    ForEach(Education.entries) { college in
                        NavigationLink(destination: EduDetails(college: college)) {
                            EduListItem(title: college.title)
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
                        Label("Mohawk Student ID", systemImage: "person.text.rectangle")
                    }
                }
            }
            .navigationTitle("Education")
        }
    }
}

extension Education: Identifiable {}

#Preview { EduCard() }
