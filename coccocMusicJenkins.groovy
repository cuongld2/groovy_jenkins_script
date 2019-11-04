import hudson.EnvVars
import hudson.model.Environment

url = "http://dev-playlist-api.coccoc.com/v1/listing"
json_file = "C:\\resources\\list_playlists.json"
response = new URL(url).getText('UTF-8')
data_json_file = new File(json_file).getText('UTF-8')
if (response == data_json_file) {
    print("\nResponse from list api is NOT CHANGED\n")
}
else{
    print("\nResponse from list api CHANGED\n")
    File response_file = new File(json_file)
    response_file.write(response, "UTF-8")
    def build = Thread.currentThread().executable
    def vars = [ENV_VAR1: 'value1']
    build.environments.add(0, Environment.create(new EnvVars(vars)))
}
