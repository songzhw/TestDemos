export const html = `
<!DOCTYPE html>
<html lang="en">
<head>
  <script>
    function resetText(){
      const str = "(default)";
      let h1 = document.getElementById("title");
      h1.innerHTML = str;
      window.ReactNativeWebView.postMessage(str);
    }
    function changeText(text) {
      let h1 = document.getElementById("title");
      h1.innerHTML = text;
      window.ReactNativeWebView.postMessage(text);
    }
  </script>
</head>
<body>
<h1 id="title">Hello World</h1>
</body>
</html>
`;
