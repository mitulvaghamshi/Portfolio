//
//  EduListItem.swift
//  Runner
//
//  Created by Mitul Vaghamshi on 2023-07-06.
//  Copyright © 2023 me.mitul. All rights reserved.
//

import SwiftUI

struct EduListItem: View {
    let title: String
    
    var body: some View {
        HStack {
            Image("\(title) Logo")
                .resizable()
                .cornerRadius(4)
                .frame(width: 60, height: 60)
            Text(title)
                .foregroundColor(.primary)
                .font(.title2)
                .bold()
        }
    }
}

#Preview {
    EduListItem(title: "Mohawk College")
}
