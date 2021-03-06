import asset.pipeline.AssetHelper
import asset.pipeline.less.LessAssetFile

class LessAssetPipelineGrailsPlugin {
    def version = "1.10.0"
    def grailsVersion = "2.0 > *"
    def title = "LESS Asset-Pipeline Plugin"
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = "Provides LESS support for the asset-pipeline static asset management plugin."
    def documentation = "http://github.com/bertramdev/less-grails-asset-pipeline"

    def license = "APACHE"
    def organization = [ name: "Bertram Capital", url: "http://www.bertramcapital.com/" ]
    def issueManagement = [ system: "GITHUB", url: "http://github.com/bertramdev/less-grails-asset-pipeline/issues" ]
    def scm = [ url: "http://github.com/bertramdev/less-grails-asset-pipeline" ]

    def doWithDynamicMethods = { ctx ->
        AssetHelper.assetSpecs << LessAssetFile

        if(application.config.grails.assets.less.compiler != 'standard') {
            LessAssetFile.compilerMode = 'less4j'
        }

    }

}
