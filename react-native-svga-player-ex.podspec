require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-svga-player-ex"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  react-native-svga-player-ex
                   DESC
  s.homepage     = "https://github.com/zoro18/react-native-svga-player-ex"
  # brief license entry:
  s.license      = "MIT"
  # optional - use expanded license entry instead:
  # s.license    = { :type => "MIT", :file => "LICENSE" }
  s.authors      = { "zoro18" => "zoro18@126.com" }
  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/zoro18/react-native-svga-player-ex.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,c,m,swift}"
  s.requires_arc = true

  s.dependency "React"
  # ...
  # s.dependency "..."
  s.dependency "SVGAPlayer"

end

